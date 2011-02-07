(ns challange.core
  (:require [clojure.contrib.str-utils2 :as s]))

(def challange "VOCDIITEIOCRUDOIANTOCSLOIOCVESTAIOCVOLIOCENTSU")

(def words (map str '(TDD, DDD, DI, DO, OO, UI, ANT, CV, IOC, LOC, SU, VO)))

(defn remove-from [s pattern]
  (s/replace s pattern ""))

(defn remove-all [s patterns]
  (let [candidates (filter #(s/contains? s %) patterns)]
    (map #(vector (vector %) (remove-from s %)) candidates)))


(defn reduce-further [so-far patterns]
  (loop [[[path s] & rest :as reductions] so-far]
    (let [candidates (filter #(s/contains? s %) patterns)
          applied (map #(vector (conj path %) (remove-from s %)) candidates)]
      (if (and (seq candidates) (> 200 (count reductions)))
        (recur (concat rest applied))
        reductions))))
