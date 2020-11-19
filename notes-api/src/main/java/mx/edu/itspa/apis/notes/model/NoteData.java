package mx.edu.itspa.apis.notes.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NoteData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-18T22:01:45.408385500-08:00[America/Los_Angeles]")
public class NoteData   {
  @JsonProperty("content")
  private String content;

  @JsonProperty("title")
  private String title;

  @JsonProperty("priority")
  private Integer priority = 0;

  public NoteData content(String content) {
    this.content = content;
    return this;
  }

  /**
   * The content of the note
   * @return content
  */
  @ApiModelProperty(required = true, value = "The content of the note")
  @NotNull


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public NoteData title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of the note
   * @return title
  */
  @ApiModelProperty(required = true, value = "The title of the note")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public NoteData priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Priority of the Note. (for sorting)
   * @return priority
  */
  @ApiModelProperty(required = true, value = "Priority of the Note. (for sorting)")
  @NotNull


  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NoteData noteData = (NoteData) o;
    return Objects.equals(this.content, noteData.content) &&
        Objects.equals(this.title, noteData.title) &&
        Objects.equals(this.priority, noteData.priority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, title, priority);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NoteData {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

