(defproject ronda/routing-schema "0.1.3-SNAPSHOT"
  :description "ronda RouteDescriptor-based schema validation."
  :url "https://github.com/xsc/ronda-routing-schema"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"
            :year 2015
            :key "mit"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ronda/routing "0.2.4"]
                 [ronda/schema "0.1.3" :exclusions [potemkin]]]
  :profiles {:dev {:plugins [[codox "0.8.10"]]
                   :codox {:project {:name "ronda/routing-schema"}
                           :src-dir-uri "https://github.com/xsc/ronda-routing-schema/blob/master/"
                           :src-linenum-anchor-prefix "L"
                           :defaults {:doc/format :markdown}}}}
  :pedantic? :abort)
