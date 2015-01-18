(ns dash.root
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [dash.views :as dash-views]))

(enable-console-print!)

(def app-state
  (atom
   {:lists
      [{:list-name "Today"
        :tasks [{:title "Get this working" :completed true}
                {:title "Eat dinner" :completed false}
                {:title "Hang out with Kevin" :completed false}]}

       {:list-name "Tomorrow"
        :tasks [{:title "Wake up" :completed false}
                {:title "Eat breakfast" :completed false}
                {:title "Render some cool stuff" :completed false}
                {:title "Play some games" :completed false}]}

       {:list-name "The Future"
        :tasks [{:title "Be successful as fuck" :completed false}
                {:title "Complete Mindfork" :completed false}
                {:title "Complete Phoenix Engine" :completed false}
                {:title "Complete Dwarf Game" :completed false}
                {:title "Die happy" :completed false}]}]
    :user
      "Mind Forker"}))

(om/root
 dash-views/lists-view
 app-state
 {:target (. js/document (getElementById "dash"))})
