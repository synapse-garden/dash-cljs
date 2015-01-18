(ns dash-test.tests
  (:require [dash.core :as dash-core]))

(def tests
  [{:should "add two and two to get four"
    :test-fn (fn [] (= (+ 2 2) 4))
    :should-be true
    :raw-fn '(fn [] (= (+ 2 2) 4))}

   {:should "get a name from a map"
    :test-fn (fn [names] (= (:bob names) "Bob Anderson"))
    :should-be true
    :raw-fn '(fn [names] (= (:bob names) "Bob Anderson"))
    :args {:bob "Bob Anderson" :jim "Slim Jim"}}

   {:should "test a Dash core fn"
    :test-fn dash-core/falsy
    :should-be false
    :raw-fn (str dash-core/falsy)}

   {:should "purposely fail, for style testing"
    :test-fn (fn [] true)
    :should-be false
    :raw-fn '(fn [] true)}
  ])
