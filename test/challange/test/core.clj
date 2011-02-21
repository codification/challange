(ns challange.test.core
  (:use [challange.core] :reload)
  (:use [midje.sweet]))

(fact 
 (solve "AA" ["A"]) => ""
 (solve "ABA" ["A" "B"]) => "" 
 (solve "AB" ["A" "X"]) => "B")

;.;. Not in rewards, but in the strength to strive, the blessing lies. --
;.;. Towbridge
(fact
 (solve the-challange the-words) => "CITERUSLOVESTALENT")
