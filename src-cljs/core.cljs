(ns hububba.core
  (:require [hububba.posts :as posts]
            [hububba.views :as views]))

(defn- start [] (do (posts/all-posts)
                    (views/create-posts)))

(set! (.-onload js/window) start)
