# 🎵 Java Music Player Application

A simple Java-based music player that enables users to create and manage playlists, interact with songs, and share their music collections with others. Users can like, dislike, and play songs, giving them control over their personal music libraries.

---

## ✨ Features

- **Playlist Management**: Create, delete, and personalize playlists  
- **Song Interaction**: Like, dislike, and listen to songs  
- **User Library**: Each user maintains a private collection of playlists  
- **Sharing**: Share playlists with other users  

---

## 🧱 Class Structure

### 1. `User`
Represents a user of the music player.

**Attributes:**
- `username`: The user’s name  
- `library`: List of playlists owned or added by the user  
- `currentlyPlaying`: The song the user is currently listening to  

**Key Methods:**
- `createPlaylist(String title, int age)`: Creates a new playlist  
- `addPlaylist(Playlist playlist)`: Adds an existing playlist to the library  
- `removePlaylist(String title)`: Removes a playlist by title  
- `likeSong(Song song)`: Likes a song and adds it to a "Liked" playlist  
- `dislikeSong(Song song)`: Registers a dislike for a song  
- `likePlaylist(Playlist playlist)`: Likes a playlist  
- `dislikePlaylist(Playlist playlist)`: Dislikes a playlist  
- `sharePlaylist(User user, int index)`: Shares a selected playlist with another user  
- `playSong(Song song)`: Starts playback of a song  
- `pauseSong(Song song)`: Pauses the currently playing song  
- `toString()`: Returns string information about the user  

---

### 2. `Playlist`
Represents a music playlist.

**Attributes:**
- `title`: Name of the playlist  
- `owner`: User who created the playlist  
- `dateCreated`: The date the playlist was made  
- `songs`: List of songs in the playlist  
- `duration`: Total time of all songs combined  
- `likes`, `dislikes`: Feedback counters for the playlist  

**Key Methods:**
- `addSong(Song song)`: Adds a song  
- `removeSong(Song song)`: Removes a song  
- `toArray()`: Returns the songs as an array  
- `topAndWorstSong()`: Finds the best and worst-rated songs in the list  
- `toString()`: Outputs playlist details  
- `compareTo(Playlist other)`: Compares playlists by creation date  

---

### 3. `Song`
Defines the properties and behavior of a song.

**Attributes:**
- `title`: Song title  
- `duration`: Length in minutes  
- `likes`, `dislikes`: Feedback counts  

**Key Methods:**
- `compareTo(Song other)`: Compares based on "like factor"  
- `equals(Object obj)`: Compares two songs for equality  
- `toString()`: Describes the song as a string  

---

## ▶️ How to Use

1. Instantiate `User`, `Playlist`, and `Song` objects.
2. Use available methods to manage music content and user interactions.
3. Run and test the application to explore playlist features and song handling.

---

Feel free to fork this project or contribute your own enhancements!
