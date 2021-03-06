(ns ronda.routing.schema
  (:require [ronda.routing
             [descriptor :as describe]
             [request :as request]
             [middleware :as rm]]
            [ronda.schema.middleware :as sm]
            [ronda.schema.coercer :refer [default-coercer-factory]]
            [ronda.schema.data
             [request :refer [compile-requests]]
             [ring :refer [normalize-request]]]))

(defn enable-schema
  "Set the schema (a schema map by request method, according to ronda.schema's
   expectations) for the given route."
  ([descriptor route-id schema]
   (enable-schema descriptor route-id schema (default-coercer-factory)))
  ([descriptor route-id schema coercer-factory]
   (let [compiled-schema (compile-requests schema coercer-factory)]
     (describe/update-metadata
      descriptor
      route-id
      #(assoc % :schema compiled-schema)))))

(defn attached-schema
  "Get schema the given request should be validated against."
  [request]
  (if-let [{:keys [meta]} (request/routing-data request)]
    (:schema meta)))

(defn has-schema?
  "Check whether the given request has a schema attached to it."
  [request]
  (map? (attached-schema request)))

(defn wrap-schemas*
  "Wrap the given handler to validate requests against a schema that was
   attached to it by the `RouteDescriptor`-based routing middleware.

   This expects such a schema to be present, as opposed to `wrap-schemas`
   which will check for its existence."
  [handler & [options]]
  (let [options (or options {})]
    (fn [request]
      (sm/handle-with-validation
        handler
        (attached-schema request)
        request
        options))))

(defn wrap-schemas
  "Wrap the given handler to validate requests against a schema that was
   attached to it by the `RouteDescriptor`-based routing middleware.

   If no schema is found, the request will only be normalized."
  [handler & [options]]
  (let [schema-handler (wrap-schemas* handler options)
        other-handler  (comp handler normalize-request)]
    (fn [request]
      (if (has-schema? request)
        (schema-handler request)
        (other-handler request)))))
