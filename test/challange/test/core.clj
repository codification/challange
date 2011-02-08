(ns challange.test.core
  (:use [challange.core] :reload)
  (:use [midje.sweet]))

(fact
 (contained-in ["A" "BB"] "ABBA") => ["A" "BB"]
 (contained-in ["BB" "CC"] "AAA") => [])

(fact "removes patterns from a string"
      (remove-from "ABA" "A") => "B"
      (remove-from "ABA" "B") => "AA")

(fact
 (remove-all "ABBA" ["A" "B"]) => [[["A"] "BB"] [["B"] "AA"]]
 (remove-all "ABBA" ["A" "C"]) => [[["A"] "BB"]])

;.;. Effort only fully releases its reward after a person refuses to
;.;. quit. -- Hill
(fact
 ( reduce-further [[["A"] "CBBC"]] ["C"]) => [[["A" "C"] "BB"]])


(fact
 (apply-candidate-path ["A"] "BBCC" "C") => [["A" "C"] "BB"])
