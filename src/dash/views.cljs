(ns dash.views
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [dash.core :as dash-core]))

(defn list-view [this-list owner]
  (reify
    om/IRender (render [_]
      (let [{:keys [list-name tasks]} this-list]
        (dom/div #js {:id (str "list-" (dash-core/name-as-id list-name))}
          (dom/h3 #js {:className "list-title"} (str list-name))
          (dom/ul #js {:className "list-contents"}
            ;(map #(let [{:keys [title completed]} %]
            ;  (dom/li #js {:className (if completed "task-completed" "task-failed")}
            ;    title) tasks)))
        ))))))

(defn lists-view [app owner]
  (reify
    om/IRender (render [_]
      (dom/div #js {:className "lists-view"}
        (dom/h2 #js {:className "lists-view_title"} (str (:user app) "'s Todo Lists"))
        (apply dom/div #js {:className "list-view"}
          (om/build-all list-view (:lists app))
      )))))