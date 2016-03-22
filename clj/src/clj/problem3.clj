(ns clj.problem3
  (:gen-class)
  (require [clojure.set :as set]))

(def problem 3)
(def description "What is the largest prime factor of the number 600851475143 ?")

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

(defn is_prime?
  [n]
  (= 2 (count (factors n))))

(defn -main
  ; 6857
  [& args]
  (println
    "Problem" (str problem ":") description "\n"
    "Solution:\n"
    (first (filter is_prime? (reverse (factors 600851475143))))))
