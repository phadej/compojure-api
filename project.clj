(defproject metosin/compojure-api "0.15.2"
  :description "Compojure Api"
  :url "https://github.com/metosin/compojure-api"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [prismatic/plumbing "0.3.3"]
                 [potemkin "0.3.8"]
                 [cheshire "5.3.1"]
                 [compojure "1.1.8"]
                 [prismatic/schema "0.2.6"]
                 [metosin/ring-http-response "0.5.0"]
                 [metosin/ring-swagger "0.13.0"]]
  :profiles {:thingie {:ring {:handler examples.thingie/app
                              :reload-paths ["src" "examples/src"]}
                       :source-paths ["examples/src"]
                       :main examples.server
                       :dependencies [[metosin/ring-swagger-ui "2.0.17"]
                                      [http-kit "2.1.19"]]}
             :uberjar {:aot :all}
             :dev {:ring {:handler examples.handler/app}
                   :plugins [[lein-clojars "0.9.1"]
                             [lein-midje "3.1.3"]
                             [lein-ring "0.8.11"]]
                   :dependencies [[peridot "0.3.0"]
                                  [javax.servlet/servlet-api "2.5"]
                                  [midje "1.6.3"]]}}
  :eastwood {:namespaces [:source-paths]
             :add-linters [:unused-namespaces]}
  :aliases {"start-thingie"    ["with-profile" "thingie" "ring" "server"]
            "http-kit-thingie" ["with-profile" "thingie" "run"]
            "aot-uberjar"      ["with-profile" "thingie,uberjar" "do" "clean," "ring" "uberjar"]})
