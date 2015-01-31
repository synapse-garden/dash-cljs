(defproject dash "0.1.0-SNAPSHOT"
  :description "A dashboard powered by Mindfork."
  :url "https://github.com/synapse-garden/dash"
  :license {:name "GNU General Public License Version 3"
            :url "http://www.gnu.org/copyleft/gpl.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2740"]
                 [compojure "1.3.1"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [cheshire "5.4.0"]
                 [figwheel "0.2.2-SNAPSHOT"]
                 [org.omcljs/om "0.8.7"]
                 [cljs-ajax "0.3.9"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-figwheel "0.2.2-SNAPSHOT"]
            [lein-ring "0.9.1"]]

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
