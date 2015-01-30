(ns dash-test.root
  (:require [om.core :as om :include-macros true]
            [dash-test.core :as dash-core]
            [dash-test.views :as dash-views]
            [dash-test.tests :as dash-tests]
            [dash-test.util :as dash-util]
            [figwheel.client :as fw]))

(enable-console-print!)

(def test-state (atom {}))
                  ;dash-core/insert-ids dash-tests/tests)
                  ;:reload false}))

(fw/start {
  :on-jsload (fn [] (do (swap! test-state
                               #(assoc %
                                  :tests (dash-core/insert-ids dash-tests/tests)
                                  :reload-count (inc (:reload-count %))))
                        (println "refresh")))
  :build-id "test"
})

(swap! test-state
       #(assoc %
          :tests (dash-core/insert-ids dash-tests/tests)
          :reload-count (inc (:reload-count %))))

(om/root
  dash-views/tests-view
  test-state
  {:target (. js/document (getElementById "tests"))})
