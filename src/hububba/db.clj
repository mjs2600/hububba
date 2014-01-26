(ns hububba.db
  (:use [monger.core :only [connect! set-db! get-db]]
        [monger.collection :only [insert find-maps]])
  (:import [org.bson.types ObjectId]))

;;; Setup the database
(connect!)
(set-db! (get-db "hububba"))

(defn new-post [post]
  (insert "posts"
          (conj post {:_id (ObjectId.)})))

(defn all-posts []
  (map #(assoc % :_id (str (:_id %))) (find-maps "posts")))
