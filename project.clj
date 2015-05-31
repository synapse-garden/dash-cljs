(defproject dash "0.1.0-SNAPSHOT"
  :description "A dashboard powered by Mindfork."
  :url "https://github.com/synapse-garden/dash"
  :license {:name "GNU General Public License Version 3"
            :url "http://www.gnu.org/copyleft/gpl.html"}

  :dependencies [[org.clojure/clojure "1.7.0-beta3"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [org.clojure/clojurescript "0.0-3269"]
                 [compojure "1.3.4"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [cheshire "5.5.0"]
                 [figwheel "0.3.3"]
                 [org.omcljs/om "0.8.7"]
                 [cljs-ajax "0.3.11"]]

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-figwheel "0.3.3"]
            [lein-ring "0.9.4"]]

  :clean-targets ^{:protect false} ["resources/public/out"
                                    "resources/public/test_out"
                                    "resources/public/script"
                                    "target"]

  :ring {:handler server.handler/test-app
         :port 3450
         :auto-reload true
         :stacktraces true
         :reload-paths ["test/server"]}

  :cljsbuild {
    :builds [{:id "dash"
              :source-paths ["src"]
              :compiler {
                :output-to "resources/public/script/dash.js"
                :output-dir "resources/public/out"
                :optimizations :none
                :cache-analysis true
                :pretty-print true
                :source-map true}}

             {:id "test"
              :source-paths ["src" "test"]
              :compiler {
                :output-to "resources/public/script/tests.js"
                :output-dir "resources/public/test_out"
                :optimizations :none
                :cache-analysis true
                :pretty-print true
                :source-map true}}]}

  :figwheel {
             :server-port 3449
             :css-dirs ["resources/public/css"]})
