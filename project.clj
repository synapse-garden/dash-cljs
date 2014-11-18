(defproject dash "0.1.0-SNAPSHOT"
  :description "A dashboard powered by Mindfork."
  :url "https://github.com/synapse-garden/dash"
  :license {:name "GNU General Public License Version 3"
            :url "http://www.gnu.org/copyleft/gpl.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 ;[org.clojure/clojurescript "0.0-2371"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 ;[om "0.7.1"]
                 [om "0.8.0-alpha2"]
                 [garden "1.2.5"]
                 [im.chit/purnam.test "0.5.1"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "dash"
              :source-paths ["src"]
              :compiler {
                :output-dir "out"
                :output-to "res/script/dash.js"
                :optimizations :none}}
             {:id "test"
              :source-paths ["test"]
              :compiler {
                :output-to "res/script/tests.js"
                :output-dir "test_out"
                :optimizations :none
                :pretty-print true}}]})
