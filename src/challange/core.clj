(ns challange.core
  (:require [clojure.string :as s]))

(def the-challange "VOCDIITEIOCRUDOIANTOCSLOIOCVESTAIOCVOLIOCENTSU")

(def the-words (map str '(TDD, DDD, DI, DO, OO, UI, ANT, CV, IOC, LOC, SU, VO)))

(defn matches-at [s pat]
  (loop [matches []
         index (.indexOf s pat)]
    (if (< -1 index)
      (recur (conj matches index)
             (.indexOf s pat (inc index)))
      matches)))

(defn reduce-once [response word]
  (let [answer (s/replace (:answer response) word "")]
    (assoc response
            :answer answer
            :by-way-of (if (not (= (:answer response) answer))
                         (conj (:by-way-of response) word)
                         (:by-way-of response)))))

(defn solve [challange words]
  (reduce reduce-once
          {:answer challange
           :by-way-of []}
          words))
