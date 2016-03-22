(ns clj.core
  (:gen-class)
  (require [clj.problem1 :as problem1])
  (require [clj.problem2 :as problem2]))

(defn -main
  [& args]
  (problem1/-main)
  (problem2/-main))
