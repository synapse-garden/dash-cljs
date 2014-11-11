(defproject dash "0.1.0-SNAPSHOT"
  :description "A dashboard powered by Mindfork."
  :url "https://github.com/synapse-garden/dash"
  :license {:name "GNU General Public License Version 3"
            :url "http://www.gnu.org/copyleft/gpl.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [om "0.7.1"]
                 [garden "1.2.5"]
                 [im.chit/purnam.test "0.5.1"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]

  ;:hooks [leiningen.cljsbuild]

  :source-paths ["src"]
  :output-dir "out"

  ;:libs [ "dash.js" ""]

  :cljsbuild {
    :builds [{:id "dash"
              :source-paths ["src"]
              :compiler {
                :output-to "res/script/dash.js"
                :optimizations :none}}
                ;:source-map true}}
             {:id "test"
              :source-paths ["src" "test"]
              :compiler {:output-to "res/script/tests.js"
                         :optimizations :none
                         :pretty-print true}}]
});    :test-commands {"unit-tests" ["slimerjs" :runner
;                                  "res/script/tests.js"]}})
