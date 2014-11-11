(ns dash-test.core
  (:require [purnam.test]
            );[dash.core :refer [poop]])
  (:use-macros [purnam.test :only [describe it is is-not]]))

(describe
  (it "works"
    (is (= 1 1) true)))

;(describe
;  (it "is poopy"
;    (is (poop) true)))
