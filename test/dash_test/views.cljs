(ns dash-test.views
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn test-view [test-case owner]
  "test-view renders a single test div with class 'passed or 'failed'."
  (reify
    om/IRender (render [_]
      (let [{:keys [id should test-fn should-be raw-fn args]} test-case]
        (dom/div (if (= should-be (test-fn args)) #js {:className "passed"} #js {:className "failed"})
          (dom/h3 nil (str "Test " id " // should " should))
          (dom/ul nil
            (if args (dom/li #js {:className "test-args"} (str "given args: " args)) "")
            (dom/li #js {:className "test-fn"} (str raw-fn))
            (dom/li #js {:className "test-should-be"} (str "should be " should-be))
            (dom/li #js {:className "test-result"} (str "is " (test-fn args)))
        ))))))

(defn tests-view [app owner]
  "tests-view renders a sequence of test maps of the form
   {:should <description> :test-fn <inline fn> :raw-fn '<same inline fn> :args <args to fn>}.
   For now, :test-fn is expected to be true if passing."
  (reify
    om/IRender (render [_]
      (dom/div #js {:id "tests"}
        (apply dom/ul nil
          (om/build-all test-view (:tests app)))))))
