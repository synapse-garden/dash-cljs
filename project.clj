(defproject dash "0.1.0-SNAPSHOT"
  :description "A dashboard powered by Mindfork."
  :url "https://github.com/synapse-garden/dash"
  :license {:name "GNU General Public License Version 3"
            :url "http://www.gnu.org/copyleft/gpl.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [om "0.7.1"]
                 [garden "1.2.5"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]
            [com.cemerick/clojurescript.test "0.3.1"]]

  :hooks [leiningen.cljsbuild]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "dash"
              :source-paths ["src"]
              :compiler {
                :output-to "dash.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}
             {:id "test"
              :source-paths ["src" "test"]
              :compiler {:output-to "tests.js"
                         :optimizations :whitespace
                         :pretty-print true}}]
    :test-commands {"unit-tests" ["phantomjs" :runner
                                  "tests.js"]}})
