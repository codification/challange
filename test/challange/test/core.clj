(ns challange.test.core
  (:use [challange.core] :reload)
  (:use [midje.sweet]))

(fact 
 (solve "AA" ["A"]) => ""
 (solve "ABA" ["A" "B"]) => "" 
 (solve "AB" ["A" "X"]) => "B")

(fact
 (solve the-challange the-words) => "CITERUSLOVESTALENT")
