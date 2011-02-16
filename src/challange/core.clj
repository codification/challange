(ns challange.core
  (:require [clojure.string :as s])
  (:require [clojure.set :as set]))

(def the-challange "VOCDIITEIOCRUDOIANTOCSLOIOCVESTAIOCVOLIOCENTSU")

(def the-words (map str '(TDD, DDD, DI, DO, OO, UI, ANT, CV, IOC, LOC, SU, VO)))

(defn remove-occurences [s patterns]
  (let [len (count s)]
    (filter #(< (count %) len) (map #(s/replace s (re-pattern %) "") patterns))))

(defn reduce-replace [challange words]
  (let [replacements (remove-occurences challange words)]
    (conj (set/union (set replacements)
                     (apply set/union (map #(reduce-replace % words) replacements)))
          challange)))

(defn solve [challange words]
  (let [comp (fn [& params] (apply < (map count params)))]
    (sort comp (reduce-replace challange words))))
