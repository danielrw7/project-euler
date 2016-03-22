(ns clj.problem3
  (:gen-class)
  (require [clj.factors]))

(def problem 3)
(def description "What is the largest prime factor of the number 600851475143 ?")

(defn is_prime?
  [n]
  (= 2 (count (clj.factors/factors n))))

(defn -main
  ; 6857
  [& args]
  (println
    "Problem" (str problem ":") description "\n"
    "Solution:\n"
    (first (filter is_prime? (reverse (clj.factors/factors 600851475143))))))
