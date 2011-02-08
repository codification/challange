(ns challange.core
  (:require [clojure.contrib.str-utils2 :as s]))

(def challange "VOCDIITEIOCRUDOIANTOCSLOIOCVESTAIOCVOLIOCENTSU")

(def words (map str '(TDD, DDD, DI, DO, OO, UI, ANT, CV, IOC, LOC, SU, VO)))

(defn remove-from [s pattern]
  (s/replace s pattern ""))

(defn contained-in [patterns string]
  (filter #(s/contains? string %) patterns))

(defn remove-all [s patterns]
  (let [candidates  (contained-in patterns s)]
    (map #(vector (vector %) (remove-from s %)) candidates)))

(defn apply-candidate-path [path s candidate]
  (vector (conj path candidate) (remove-from s candidate)))

(defmacro dbg[x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))


(defn reduce-further [so-far patterns]
  (loop [[[path s] & rest :as reductions] so-far]
    (let [candidates (contained-in patterns s)
          applied (map (partial apply-candidate-path path s) candidates)]
      (if (and (seq candidates) (> 200 (count reductions)))
        (recur (concat rest applied))
        reductions))))

