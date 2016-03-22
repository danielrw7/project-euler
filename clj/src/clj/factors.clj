(ns clj.factors
  (require [clojure.set :as set]))


(defn half_factors
  [n]
  (filter #(= 0 (mod n %)) (range 1 (Math/floor (Math/sqrt n)))))

(defn reverse_factors
  [n f]
  (map #(/ n %) f))

(defn factors
  [n]
  (let [f (half_factors n)]
    (set/union f (reverse_factors n f))))
