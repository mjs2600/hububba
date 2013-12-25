(ns hububba.persistence
  (:require [monger.core :as mg]))

(mg/connect!)

(mg/set-db! (mg/get-db "hububba"))
