package mx.edu.itspa.apis.notes.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import mx.edu.itspa.apis.notes.db.DB;
import mx.edu.itspa.apis.notes.exception.NotFoundException;
import mx.edu.itspa.apis.notes.model.Note;
import mx.edu.itspa.apis.notes.model.NoteData;

public class NotesServiceImpl implements NotesService {
	
	private DB db;
	public NotesServiceImpl(DB database) {
		this.db = database;
	}

	@Override
	public Note getNoteById(UUID id) throws NotFoundException {
		return db.getById(id);
	}

	@Override
	public List<Note> getAll() {
		return db.getAll();
	}

	@Override
	public void createNote(NoteData noteData) {
		Note note = new Note()
				.id(UUID.randomUUID())
				.createdOn(OffsetDateTime.now())
				.title(noteData.getTitle())
				.content(noteData.getContent())
				.priority(noteData.getPriority());
		db.addNote(note);
	}

	@Override
	public void updateNote(UUID id, NoteData noteData) throws NotFoundException {
		Note originalNote = getNoteById(id);
		Note updatedNote = originalNote
				.title(noteData.getTitle())
				.content(noteData.getContent())
				.priority(noteData.getPriority());
		db.updateNote(id, updatedNote);
	}

	@Override
	public void deleteNote(UUID id) throws NotFoundException {
		db.deleteNote(id);
	}

}
