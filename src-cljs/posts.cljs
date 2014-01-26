(ns hububba.posts
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.core.async :refer [timeout <!]]
            [ajax.core :refer [GET POST]]
            [hububba.views :as views]))

(defn render-posts [content]
  (views/add-posts content))

(defn all-posts []
  (.log js/console "Getting posts...")
  (GET "/posts"
       {:handler render-posts}))

(defn create-post [post]
  (do (.log js/console (pr-str post))
      (POST "/posts"
            {:params post
             :handler render-posts})))

(defn poll []
  (go (while true
              (<! (timeout 1000))
              (all-posts))))
