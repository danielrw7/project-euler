(ns clj.problem1
  (:gen-class))

(def problem 1)
(def description "Find the sum of all the multiples of 3 or 5 below 1000.")

(defn -main
  ; 233168
  [& args]
  (println
    "Problem" (str problem ":") description "\n"
    "Solution:\n"
    (apply +
      (filter
        #(or
          (= 0 (mod % 3))
          (= 0 (mod % 5)))
        (range 1 1000)))))
