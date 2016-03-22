(ns clj.problem4
  (:gen-class)
  (require [clj.factors]))

(def problem 4)
(def description "Find the largest palindrome made from the product of two 3-digit numbers.")

(defn is_palindrome?
  [n]
  (let [digits (str n)
        n (Math/ceil (/ (count digits) 2))]
    (= (take n digits) (take n (reverse digits)))))

(defn products
  ([a b] (products a b []))
  ([a b l]
    (if (= 0 b)
      l
      (if (= 0 (dec a))
        (lazy-seq (cons (* a b) (products 999 (dec b) l)))
        (lazy-seq (cons (* a b) (products (dec a) b l)))))))

(defn -main
  ; 906609
  [& args]
  (println
    "Problem" (str problem ":") description "\n"
    "Solution:\n"
    (first (filter is_palindrome? (reverse (sort (products 999 999)))))))
