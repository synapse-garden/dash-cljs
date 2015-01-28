(defproject dash "0.1.0-SNAPSHOT"
  :description "A dashboard powered by Mindfork."
  :url "https://github.com/synapse-garden/dash"
  :license {:name "GNU General Public License Version 3"
            :url "http://www.gnu.org/copyleft/gpl.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2727"]
                 [compojure "1.3.1"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [cheshire "5.4.0"]
                 [figwheel "0.2.2-SNAPSHOT"]
                 [org.omcljs/om "0.8.7"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-figwheel "0.2.2-SNAPSHOT"]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/out"
                                    "resources/test_out"
                                    "resources/script"]

  :cljsbuild {
    :builds [{:id "dash"
              :source-paths ["src"]
              :compiler {
                :output-to "resources/script/dash.js"
                :output-dir "resources/out"
                :optimizations :none
                :cache-analysis true}}
             {:id "test"
              :source-paths ["src" "test"]
              :compiler {
                :output-to "resources/script/tests.js"
                :output-dir "resources/test_out"
                :optimizations :none
                :cache-analysis true
                :pretty-print true
                :source-map true}}]}
  :figwheel {
             :http-server-root ""
             :server-port 3449
             :ring-handler server.handler/test-app
             :open-file-command "LightTable"
             :css-dirs ["resources/css"]})
