(ns dash.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [clojure.string :as string]
            [garden.core :as gdn]))

(enable-console-print!)

(defn falsy [] true)

(def app-state
  (atom
   {:lists
      [{:name "Today"
        :tasks ["Get this working" "Eat dinner" "Hang out with Bodor"]}
       {:name "Tomorrow"
        :tasks ["Wake up" "Eat breakfast" "Render some cool stuff lol" "Take a big grump dump" "Play some muc"]}
       {:name "The Future"
        :tasks ["Be fucking successful as fuck" "Complete Mindfork" "Complete Phoenix Engine" "Complete Dwarf Game" "Die happy"]}]
    :user
      "User"}))

(defn todo-view [app owner]
  (reify
    om/IRender (render [_]
      (dom/div #js {:id "todolist"}
         (dom/h2 nil (str (:user app) "'s Todo Lists" ))
         (dom/h3 nil "grump")))))

(om/root todo-view app-state
  {:target (. js/document (getElementById "dash"))})
