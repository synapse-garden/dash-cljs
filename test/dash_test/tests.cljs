(ns dash-test.tests
  (:require [dash.core :as dash-core]))

(defn tests []
    [{:should "format a name as suitable for :className"
      :test-fn dash-core/name-as-id
      :args "Some complicated name"
      :should-be "some_complicated_name"
      :raw-fn '(dash.core/name-as-id)}

     {:should "retrieve a test map"
      :test-fn (fn [m]
                 (get-in
                   (filterv #(= "Soon" (get-in % [:list-name]))
                     (get ((dash-core/fetch-updates m)) :lists))
                   [0 :tasks 0 :title]))
      :args {}
      :should-be "Get this working"
      :raw-fn '(dash-core/fetch-updates)}
    ])
