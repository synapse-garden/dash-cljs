(ns dash-test.tests
  (:require [dash.core :as dash-core]))

(defn tests []
  ;(constantly
    [{:should "format a name as suitable for :className"
      :test-fn dash-core/name-as-id
      :args "Some complicated name"
      :should-be "some_complicated_name"
      :raw-fn '(dash.core/name-as-id)}

     {:should "purposely fail, for style testing"
      :test-fn (fn [] true)
      :should-be false
      :raw-fn '(fn [] true)}
    ]);)
