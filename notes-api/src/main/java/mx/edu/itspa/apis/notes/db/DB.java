package mx.edu.itspa.apis.notes.db;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import mx.edu.itspa.apis.notes.exception.NotFoundException;
import mx.edu.itspa.apis.notes.model.Note;

public class DB {

	private static DB INSTANCE = null;
	private static final Map<UUID, Note> notes = new HashMap<>();
	static {
		Note note1 = new Note()
				.id(UUID.randomUUID())
				.title("Revisar TikTok")
				.content("Revisar el tiktok de mis amigos y hacerles bullying.")
				.createdOn(OffsetDateTime.now())
				.priority(1);

		Note note2 = new Note()
				.id(UUID.randomUUID())
				.title("Revisar Instagram")
				.content("Revisar el perfil del novi@ y stalkear sus amig@s.")
				.createdOn(OffsetDateTime.now())
				.priority(0);

		Note note3 = new Note()
				.id(UUID.randomUUID())
				.title("Hacer la tarea")
				.content("Mandar por correo el ejercicio de programacion web")
				.createdOn(OffsetDateTime.now())
				.priority(5);

		notes.put(note1.getId(), note1);
		notes.put(note2.getId(), note2);
		notes.put(note3.getId(), note3);
	}

	private DB() {
	}

	public static DB getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DB();
		}

		return INSTANCE;
	}

	public List<Note> getAll() {
		return new ArrayList<>(notes.values());
	}
	
	public Note getById(UUID id) throws NotFoundException {
		if (!notes.containsKey(id)) {
			throw new NotFoundException("Note not found. Note id=" + id.toString());
		}
		return notes.get(id);
	}

	public void addNote(Note note) {
		notes.put(note.getId(), note);
	}

	public void updateNote(UUID id, Note newNote) throws NotFoundException {
		if (!notes.containsKey(id)) {
			throw new NotFoundException("Note not found. Note id=" + id.toString());
		}
		notes.replace(id, newNote);
	}

	public void deleteNote(UUID id) throws NotFoundException {
		if (null == notes.remove(id)) {
			throw new NotFoundException("Note not found. Note id=" + id.toString());
		}
	}

}
