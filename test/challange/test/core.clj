(ns challange.test.core
  (:use [challange.core] :reload)
  (:use [midje.sweet]))

(fact "removes from a string"
      (remove-from "A" "ABA") => "B")
