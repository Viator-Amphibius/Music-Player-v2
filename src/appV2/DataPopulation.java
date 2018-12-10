package appV2;

import componentsV2.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataPopulation {
	public static void populateMusicPlayer()
	{
		//add an artist with two albums each containing three songs.
		Artist Trivium = MusicPlayer.addArtist("Trivium", LocalDate.of(1999, 1, 1) , "Heavy Metal", new ArrayList<String>());
		Album _Shogun = MusicPlayer.addAlbum("Shogun", "Heavy Metal", LocalDate.of(2008, 9, 30), Trivium);
		ArrayList<Album> Shogun = new ArrayList<>();
		Shogun.add(_Shogun);
		ArrayList<Song> ShogunSongs = new ArrayList<>();
		ShogunSongs.add(MusicPlayer.addSong("Kirisute Gomen", Shogun.get(0).getGenre(), Shogun.get(0).getReleaseDate(), Shogun, Shogun.get(0).getArtist()));
		ShogunSongs.add(MusicPlayer.addSong("Down From the Sky", Shogun.get(0).getGenre(), Shogun.get(0).getReleaseDate(), Shogun, Shogun.get(0).getArtist()));
		ShogunSongs.add(MusicPlayer.addSong("Insurrection", Shogun.get(0).getGenre(), Shogun.get(0).getReleaseDate(), Shogun, Shogun.get(0).getArtist()));
		Album _TSATS = MusicPlayer.addAlbum("The Sin and the Sentence", "Heavy Metal", LocalDate.of(2017, 10, 17), Trivium);
		ArrayList<Album> TSATS = new ArrayList<>();
		TSATS.add(_TSATS);
		ArrayList<Song> TSATSSongs = new ArrayList<>();
		TSATSSongs.add(MusicPlayer.addSong("Beyond Oblivion", TSATS.get(0).getGenre(), TSATS.get(0).getReleaseDate(), TSATS, TSATS.get(0).getArtist()));
		TSATSSongs.add(MusicPlayer.addSong("Sever the Hand", TSATS.get(0).getGenre(), TSATS.get(0).getReleaseDate(), TSATS, TSATS.get(0).getArtist()));
		TSATSSongs.add(MusicPlayer.addSong("Thrown into the Fire", TSATS.get(0).getGenre(), TSATS.get(0).getReleaseDate(), TSATS, TSATS.get(0).getArtist()));
		Album _SITS = MusicPlayer.addAlbum("Silence in the Snow", "Heavy Metal", LocalDate.of(2015, 10, 2), Trivium);
		ArrayList<Album> SITS = new ArrayList<>();
		SITS.add(_SITS);
		ArrayList<Song> SITSSongs = new ArrayList<>();
		SITSSongs.add(MusicPlayer.addSong("Blind Leading the Blind", SITS.get(0).getGenre(), SITS.get(0).getReleaseDate(), SITS, SITS.get(0).getArtist()));
		SITSSongs.add(MusicPlayer.addSong("Pull Me from the Void", SITS.get(0).getGenre(), SITS.get(0).getReleaseDate(), SITS, SITS.get(0).getArtist()));
		SITSSongs.add(MusicPlayer.addSong("Until the World Goes Cold", SITS.get(0).getGenre(), SITS.get(0).getReleaseDate(), SITS, SITS.get(0).getArtist()));
		
		//add an artist with two albums each containing three songs.
		Artist InVain = MusicPlayer.addArtist("In Vain", LocalDate.of(2003, 1, 1), "Melodic Death Metal", new ArrayList<String>());
		Album _Currents = MusicPlayer.addAlbum("Currents", "Melodic Death Metal", LocalDate.of(2018, 1, 26), InVain);
		ArrayList<Album> Currents = new ArrayList<>();
		Currents.add(_Currents);
		ArrayList<Song> CurrentsSongs = new ArrayList<>();
		CurrentsSongs.add(MusicPlayer.addSong("Seekers of the Truth", Currents.get(0).getGenre(), Currents.get(0).getReleaseDate(), Currents, Currents.get(0).getArtist()));
		CurrentsSongs.add(MusicPlayer.addSong("Origin", Currents.get(0).getGenre(), Currents.get(0).getReleaseDate(), Currents, Currents.get(0).getArtist()));
		CurrentsSongs.add(MusicPlayer.addSong("As the Black Horde Storms", Currents.get(0).getGenre(), Currents.get(0).getReleaseDate(), Currents, Currents.get(0).getArtist()));
		Album _Aenigma = MusicPlayer.addAlbum("Aenigma", "Melodic Death Metal", LocalDate.of(2013, 3, 11), InVain);
		ArrayList<Album> Aenigma = new ArrayList<>();
		Aenigma.add(_Aenigma);
		ArrayList<Song> AenigmaSongs = new ArrayList<>();
		AenigmaSongs.add(MusicPlayer.addSong("Against the Grain", Aenigma.get(0).getGenre(), Aenigma.get(0).getReleaseDate(), Aenigma, Aenigma.get(0).getArtist()));
		AenigmaSongs.add(MusicPlayer.addSong("Image of Time", Aenigma.get(0).getGenre(), Aenigma.get(0).getReleaseDate(), Aenigma, Aenigma.get(0).getArtist()));
		AenigmaSongs.add(MusicPlayer.addSong("To the Core", Aenigma.get(0).getGenre(), Aenigma.get(0).getReleaseDate(), Aenigma, Aenigma.get(0).getArtist()));
		Album _Mantra = MusicPlayer.addAlbum("Mantra", "Melodic Death Metal", LocalDate.of(2010, 1, 18), InVain);
		ArrayList<Album> Mantra = new ArrayList<>();
		Mantra.add(_Mantra);
		ArrayList<Song> MantraSongs = new ArrayList<>();
		MantraSongs.add(MusicPlayer.addSong("Captivating Solitude", Mantra.get(0).getGenre(), Mantra.get(0).getReleaseDate(), Mantra, Mantra.get(0).getArtist()));
		MantraSongs.add(MusicPlayer.addSong("Dark Prophets, Black Hearts", Mantra.get(0).getGenre(), Mantra.get(0).getReleaseDate(), Mantra, Mantra.get(0).getArtist()));
		MantraSongs.add(MusicPlayer.addSong("Wayakin", Mantra.get(0).getGenre(), Mantra.get(0).getReleaseDate(), Mantra, Mantra.get(0).getArtist()));
		
		//add three users
		User Luna = MusicPlayer.addUser("Luna", LocalDate.of(1992,1,1), "Luna",new ArrayList<Album>(), new ArrayList<Playlist>(), "Luna@NASA.com");
		MusicPlayer.followPerson(Luna, Trivium);
		MusicPlayer.followPerson(Luna, InVain);
		User Ganymede = MusicPlayer.addUser("Ganymede", LocalDate.of(1992,1,1), "Ganymede", new ArrayList<Album>(), new ArrayList<Playlist>(), "Ganymede@NASA.com");
		MusicPlayer.followPerson(Ganymede, Luna);
		MusicPlayer.followPerson(Ganymede, Trivium);
		MusicPlayer.followPerson(Ganymede, InVain);
		User Titan = MusicPlayer.addUser("Titan", LocalDate.of(1992,1,1), "Titan", new ArrayList<Album>(), new ArrayList<Playlist>(), "Titan@NASA.com");
		MusicPlayer.followPerson(Titan, Luna);
		MusicPlayer.followPerson(Titan, Ganymede);
		MusicPlayer.followPerson(Titan, Trivium);
		MusicPlayer.followPerson(Titan, InVain);
		
		//add a playlist containing some songs
		ArrayList<Song> songs1 = new ArrayList<>();
		songs1.add(ShogunSongs.get(0));
		songs1.add(TSATSSongs.get(0));
		songs1.add(SITSSongs.get(0));
		songs1.add(CurrentsSongs.get(0));
		songs1.add(AenigmaSongs.get(0));
		songs1.add(MantraSongs.get(0));
		MusicPlayer.addPlaylist("First Mix", Luna, LocalDate.of(2018, 10, 15), songs1);
		
		//add a playlist containing some songs
		ArrayList<Song> songs2 = new ArrayList<>();
		songs2.add(ShogunSongs.get(1));
		songs2.add(TSATSSongs.get(1));
		songs2.add(SITSSongs.get(1));
		songs2.add(CurrentsSongs.get(1));
		songs2.add(AenigmaSongs.get(1));
		songs2.add(MantraSongs.get(1));
		MusicPlayer.addPlaylist("Second Mix", Ganymede, LocalDate.of(2018, 10, 16), songs2);
		
		//add a playlist containing some songs
		ArrayList<Song> songs3 = new ArrayList<>();
		songs3.add(ShogunSongs.get(2));
		songs3.add(TSATSSongs.get(2));
		songs3.add(SITSSongs.get(2));
		songs3.add(CurrentsSongs.get(2));
		songs3.add(AenigmaSongs.get(2));
		songs3.add(MantraSongs.get(2));
		MusicPlayer.addPlaylist("Third Mix", Titan, LocalDate.of(2018, 10, 17), songs3);
	}
}
