(ns dash-test.core
  (:require [purnam.test])
  (:use-macros [purnam.test :only [describe it is is-not]]))

(describe "Normal (expect) usage works"
  (it "should be true"
    (expect true :to-be true)))
