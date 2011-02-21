(ns challange.core
  (:require [clojure.set :as set]))

(def the-challange "VOCDIITEIOCRUDOIANTOCSLOIOCVESTAIOCVOLIOCENTSU")

(def the-words (map str '(TDD, DDD, DI, DO, OO, UI, ANT, CV, IOC, LOC, SU, VO)))

(defn reduce-by [^String s words]
  "For each word, tries to remove it from the first string.
   Returns the candidates that turned out shorter"
  (let [len (.length s)
        candidates (map #(reduce str (.split s %)) words)]
    (filter (fn [^String c] (< (.length c) len)) candidates)))

(defn reduce-replace [challange words]
  (let [replacements (reduce-by challange words)]
    (conj (set/union (set replacements)
                     (apply set/union (map #(reduce-replace % words) replacements)))
          challange)))

(defn solve [challange words]
  (let [comp (fn [& params] (apply < (map count params)))]
    (first (sort comp (reduce-replace challange words)))))
