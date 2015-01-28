(ns dash-test.root
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [dash-test.core :as dash-core]
            [dash-test.views :as dash-views]
            [dash-test.tests :as dash-tests]
            [figwheel.client :as fw]))

(enable-console-print!)

(println "Text printed using println will be displayed in the js console.")

(fw/start {
  :on-jsload (fn [] (println "reloaded"));; optional callback
  :build-id "test"
})

(def test-state (atom {:tests (dash-core/insert-ids dash-tests/tests)}))

(om/root
  dash-views/tests-view
  test-state
  {:target (. js/document (getElementById "tests"))})
