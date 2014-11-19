(ns dash-test.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [clojure.string :as string]
            [garden.core :as gdn]
            [dash-test.tests :as dash-tests]))

(def test-state
  (atom {}))

(enable-console-print!)

(defn insert-ids [maps]
  "insert-ids takes a sequence of maps and updates each element with an :id
   from sequential integers > 1"
  (map (fn [m i](update-in m [:id] i) maps (iterate inc 1))))

(defn test-view [test-case owner]
  (reify
    om/IRender (render [_]
      (dom/li #js {:id (:should test-case)}))))

(defn tests-view [app owner]
  (reify
    om/IRender (render [_]
      (dom/div #js {:id "tests"}
        (apply dom/ul nil
          (om/build-all test-view (insert-ids dash-tests/tests))))))

(om/root
  tests-view
  test-state
  {:target (. js/document (getElementById "tests"))})
