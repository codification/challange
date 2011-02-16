(ns challange.test.core
  (:use [challange.core] :reload)
  (:use [midje.sweet]))

;.;. Without work, all life goes rotten. -- Camus
(fact 
 (solve "AA" ["A"]) => ["" "AA"]
 (solve "ABA" ["A" "B"]) => ["" "B" "AA" "ABA"] 
 (solve "AB" ["A" "X"]) => ["B" "AB"])

(fact
 (solve the-challange the-words) => (has-prefix "CITERUSLOVESTALENT"))
