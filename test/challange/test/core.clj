(ns challange.test.core
  (:use [challange.core] :reload)
  (:use [midje.sweet]))

(fact "removes patterns from a string"
      (remove-from "ABA" "A") => "B"
      (remove-from "ABA" "B") => "AA")

;.;. Before the reward there must be labor. You plant before you
;.;. harvest. You sow in tears before you reap joy. -- Ransom
(fact
 (remove-all "ABBA" ["A" "B"]) => [[["A"] "BB"] [["B"] "AA"]]
 (remove-all "ABBA" ["A" "C"]) => [[["A"] "BB"]])

(fact
 ( reduce-further [["A"] "CBBC"] ["C"]) => [[["A" "C"] "BB"]])
