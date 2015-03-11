(defproject ronda/routing-schema "0.1.2-SNAPSHOT"
  :description "ronda RouteDescriptor-based schema validation."
  :url "https://github.com/xsc/ronda-routing-schema"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-alpha5"]
                 [ronda/routing "0.1.3"]
                 [ronda/schema "0.1.0-RC3"]]
  :profiles {:dev {:plugins [[codox "0.8.10"]]
                   :codox {:project {:name "ronda/routing-schema"}
                           :src-dir-uri "https://github.com/xsc/ronda-routing-schema/blob/master/"
                           :src-linenum-anchor-prefix "L"
                           :defaults {:doc/format :markdown}}}}
  :pedantic? :abort)
