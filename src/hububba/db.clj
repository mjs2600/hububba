(ns hububba.db
  (:use [monger.core :only [connect! set-db! get-db]]
        [monger.collection :only [insert find-maps]])
  (:import [org.bson.types ObjectId]))

;;; Setup the database
(connect!)
(set-db! (get-db "hububba"))

(defn new-post [title content]
  (insert "posts"
          {:_id (ObjectId.)
           :title title
           :content content}))

(defn all-posts []
  (find-maps "posts"))
