(ns challange.test.core
  (:use [challange.core] :reload)
  (:use [midje.sweet]))

(fact "removes patterns from a string"
      (remove-from "ABA" "A") => "B"
      (remove-from "ABA" "B") => "AA")
