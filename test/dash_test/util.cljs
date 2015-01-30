(ns dash-test.util
  (:require [om.core :as om :include-macros true]))

(defn set-reload! [state]
  "Trigger a reload on the testing state atom."
  (swap! state #(update-in % [:reload] (constantly true))))

(defn unset-reload! [state]
  "Trigger a reload on the testing state atom."
  (swap! state #(update-in % [:reload] (constantly false))))

(defn callout-reload [state]
  "Report the state of the reload key."
  (println (str "reload: " (:reload state))))

(defn refresh-component! [state component]
  "If :reload true in state, om/refresh! component"
  (if (:reload state) (om/refresh! component)))
