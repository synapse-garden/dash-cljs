(ns dash.util
  (:require [clojure.string :as string]))

(defn name-as-id [list-name]
  "Cleanse a named thing into a usable css class name or id."
  (string/lower-case (string/replace list-name "[\\s]" "_" )))
