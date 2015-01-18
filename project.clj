(defproject dash "0.1.0-SNAPSHOT"
  :description "A dashboard powered by Mindfork."
  :url "https://github.com/synapse-garden/dash"
  :license {:name "GNU General Public License Version 3"
            :url "http://www.gnu.org/copyleft/gpl.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2665"]
                 [figwheel "0.2.1-SNAPSHOT"]
                 [org.om/om "0.8.0"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-figwheel "0.2.1-SNAPSHOT"]]

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
                :optimizations :none}}
             {:id "test"
              :source-paths ["src" "test"]
              :compiler {
                :output-to "resources/script/tests.js"
                :output-dir "resources/test_out"
                :optimizations :none
                :pretty-print true
                :source-map true}}]}
  :figwheel {
             :http-server-root ""
             :server-port 3449
             :css-dirs ["resources/css"]})
