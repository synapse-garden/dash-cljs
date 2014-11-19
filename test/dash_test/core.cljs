; TODO: make tests eval
; TODO: figure out a better way to wrap test fns

(ns dash-test.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [clojure.string :as string]
            [dash-test.tests :as dash-tests]))

(def test-state
  (atom {}))

(enable-console-print!)

(defn insert-ids [maps]
  "insert-ids takes a sequence of maps and updates each element with an :id
   from sequential integers >= 1."
  (map (fn [m i] (assoc m :id i))
    maps
    (iterate inc 1)))

(defn test-view [test-case owner]
  "test-view renders a single test."
  (reify
    om/IRender (render [_]
      (let [test-fn (:fn test-case)]
        (dom/div nil
          (dom/h3 nil (str "Test " (:id test-case) ": should " (:should test-case)))
          (dom/ul nil
            (dom/li nil (str test-fn))
            (if (:args test-case)
              (let [args (:args test-case)]
                (dom/li nil (str args))))))))))
                ;(dom/li nil ((test-fn) args)))))))))

(defn tests-view [app owner]
  "tests-view renders a sequence of test maps of the form
   {:should <description> :fn <inline fn> :args <args to fn>}."
  (reify
    om/IRender (render [_]
      (dom/div #js {:id "tests"}
        (apply dom/ul nil
          (om/build-all test-view (insert-ids dash-tests/tests)))))))

(om/root
  tests-view
  test-state
  {:target (. js/document (getElementById "tests"))})
